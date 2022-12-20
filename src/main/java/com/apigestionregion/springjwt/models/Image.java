package com.apigestionregion.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] bytes;


    public Image(String originalFilename, String contentType, byte[] bytes) {
        this.name = originalFilename;
        this.type = contentType;
        this.bytes = bytes;

    }
}