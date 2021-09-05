package com.example.demo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongInfoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "")
    @Size(min = 1, max = 800, message = "Vui lòng nhập thông tin")
    @Pattern(regexp = "^[a-zA-Z0-9_ {,}]*$", message = "Không nhập các kí tự đặc biệt")
    private String name;

    @NotBlank(message = "")
    @Size(min = 1, max = 300, message = "Vui lòng nhập thông tin")
    @Pattern(regexp = "^[a-zA-Z0-9_ {,}]*$", message = "Không nhập các kí tự đặc biệt")
    private String artist;

    @NotBlank(message = "")
    @Size(min = 1, max = 1000, message = "Vui lòng nhập thông tin")
    @Pattern(regexp = "^[a-zA-Z0-9_ {,}]*$", message = "Không nhập các kí tự đặc biệt khác, trừ ','")
    private String kind;

    public SongInfoDto(Integer id, @NotBlank(message = "Vui lòng nhập thông tin") @Size(min = 1, max = 800) @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không nhập các kí tự đặc biệt") String name, @NotBlank(message = "Vui lòng nhập thông tin") @Size(min = 1, max = 300) @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không nhập các kí tự đặc biệt") String artist, @NotBlank(message = "Vui lòng nhập thông tin") @Size(min = 1, max = 1000) @Pattern(regexp = "^[a-zA-Z0-9{,}]*$", message = "Không nhập các kí tự đặc biệt khác, trừ ',')") String kind) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kind = kind;
    }

    public SongInfoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
