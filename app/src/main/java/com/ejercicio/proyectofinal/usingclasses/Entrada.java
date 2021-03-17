package com.ejercicio.proyectofinal.usingclasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Entrada implements Parcelable {


    private String titulo, imagenprinc, fecha, text1, text2, text3, img1, img2;

    public Entrada (String titulo, String imagenprinc, String fecha, String text1, String text2, String text3, String img1, String img2){
        this.titulo = titulo;
        this.imagenprinc = imagenprinc;
        this.fecha = fecha;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.img1 = img1;
        this.img2 = img2;
    }


    protected Entrada(Parcel in) {
        titulo = in.readString();
        imagenprinc = in.readString();
        fecha = in.readString();
        text1 = in.readString();
        text2 = in.readString();
        text3 = in.readString();
        img1 = in.readString();
        img2 = in.readString();
    }

    public static final Creator<Entrada> CREATOR = new Creator<Entrada>() {
        @Override
        public Entrada createFromParcel(Parcel in) {
            return new Entrada(in);
        }

        @Override
        public Entrada[] newArray(int size) {
            return new Entrada[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagenprinc() {
        return imagenprinc;
    }

    public void setImagenprinc(String imagenprinc) {
        this.imagenprinc = imagenprinc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(imagenprinc);
        dest.writeString(fecha);
        dest.writeString(text1);
        dest.writeString(text2);
        dest.writeString(text3);
        dest.writeString(img1);
        dest.writeString(img2);
    }

    @Override
    public int describeContents() {
        return 0;
    }



}
