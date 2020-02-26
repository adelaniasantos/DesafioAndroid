package com.digitalhouse.digitalhousefoods.model;
import android.os.Parcel;
import android.os.Parcelable;

public class Cardapio implements Parcelable {
    private String nomePrato;
    private int imagemPrato;

    public Cardapio(String nomePrato, int imagemPrato) {
              this.nomePrato = nomePrato;
        this.imagemPrato = imagemPrato;
    }

    protected Cardapio(Parcel in) {
        nomePrato = in.readString();
        imagemPrato = in.readInt();
    }

    public static final Creator<Cardapio> CREATOR = new Creator<Cardapio>() {
        @Override
        public Cardapio createFromParcel(Parcel in) {
            return new Cardapio(in);
        }

        @Override
        public Cardapio[] newArray(int size) {
            return new Cardapio[size];
        }
    };

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public int getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(int imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomePrato);
        dest.writeInt(imagemPrato);
    }
}
