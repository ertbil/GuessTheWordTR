package com.examples.kelimebil;

import java.util.Random;

public class GameSArrays {
    private String[] cities = {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara",
            "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis",
            "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli",
            "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta",
            "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri",
            "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir",
            "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop",
            "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa",
            "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman",
            "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova",
            "Karabük", "Kilis", "Osmaniye", "Düzce"}; //github sağolsun

    private String[] names = {"Ahmet","Mehmet","Ali","Ayşe","Tuğçe","Aslıhan","Berk","Eren"
            ,"Doğukan","Metin","Kutay","Hümeyra","Murtaza","Ömer","Tolga","Yasemin","Hamdi","Melike","Kubilay","İsmail"
            ,"Can","Tuğba","Resul","Şevval","Bora","Alperen","Kaan","Emir","Mansur","Ekrem","Recep"
            ,"Muharrem","Kemal","Devlet","Meral","Yılmaz","Oğuz","Yüksel","Yusuf","Emine","Naz","Yavuz"
            ,"Selim","Süleyman","Hakan","Mustafa","Muhammed","Musa","İsa","Gül","Rıza","Okan"
            ,"Galip","Necip","Enver","Talat","Rauf","İsmet","Fuat","Mahsar","Özkan","Ferdi","Müslüm"
            ,"Orhan","Osman","Murat","Beyazıd","Ertuğrul","Harun","Behzat","Ercüment","Ateş","Sevil","Eray"
            ,"Yağız","Furkan","Berat","Ersin","Aysun","Güldal","Melih"};//ctrl c + v sağ olsun

    private String questions[][]= {cities,names};

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[][] getQuestions() {
        return questions;
    }

    public void setQuestions(String[][] questions) {
        this.questions = questions;
    }

    public String[] randomGetter(){
        Random random = new Random();
        if (random.nextInt(2)==1){
            return getNames();
        }
        else {
            return getCities();
        }
    }


}

