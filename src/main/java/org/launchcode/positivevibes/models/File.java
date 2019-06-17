package org.launchcode.positivevibes.models;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
@Table(name="files")
public class File {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="file_directory", length=100)
    private String fileDirectory;

    @Column(name="file_name", length=100)
    private String fileName;

    @Column(name="file_extension", length=5)
    private String fileExtension;

    @Transient
    private String fileBaseName;

    public File() {

    }

    public File(
            String fileDirectory, String fileName,
            String fileExtension, String fileBaseName
    ) {
        this.fileDirectory = fileDirectory;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileBaseName = fileBaseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileBaseName() {
        return fileBaseName;
    }

    public void setFileBaseName(String fileBaseName) {
        this.fileBaseName = fileBaseName;
    }

    public Path getFilePath() {
        if (fileName == null || fileDirectory == null) {
            return null;
        }

        return Paths.get(fileDirectory, fileName);
    }
}
