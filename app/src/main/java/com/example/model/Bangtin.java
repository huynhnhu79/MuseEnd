package com.example.model;

public class Bangtin {
    private int bangtinThumb, bangtinThumbnote;
    //    private int bangtinLike;
    private String bangtinchitiet, bangtintieude;

    public Bangtin(int bangtinThumb, String bangtinchitiet, String bangtintieude, int bangtinThumbnote) {
        this.bangtinThumb = bangtinThumb;
        this.bangtinchitiet = bangtinchitiet;
        this.bangtintieude = bangtintieude;
        this.bangtinThumbnote = bangtinThumbnote;
    }

    public int getBangtinThumbnote() {
        return bangtinThumbnote;
    }

    public void setBangtinThumbnote(int bangtinThumbnote) {
        this.bangtinThumbnote = bangtinThumbnote;
    }

    public String getBangtintieude() {
        return bangtintieude;
    }

    public void setBangtintieude(String bangtintieude) {
        this.bangtintieude = bangtintieude;
    }
//    public int getBangtinLike() {
//        return bangtinLike;
//    }
//
//    public void setBangtinLike(int bangtinLike) {
//        this.bangtinLike = bangtinLike;
//    }

    public String getBangtinchitiet() {
        return bangtinchitiet;
    }

    public void setBangtinchitiet(String bangtinchitiet) {
        this.bangtinchitiet = bangtinchitiet;
    }

    public int getBangtinThumb() {
        return bangtinThumb;
    }

    public void setBangtinThumb(int bangtinThumb) {
        this.bangtinThumb = bangtinThumb;
    }
}
