package sew9.worttrainer.spieljungecarti;

/**
 * Diese Klasse repräsentiert ein Bild mit einer URL und einem Namen. 
 * Sie stellt Methoden bereit, um die URL und den Namen abzurufen.
 */

public class Pic {

    private String url;
    private String name;

    public Pic(String url, String name) {
        if (url == null || name == null) {
            throw new IllegalArgumentException("url and name must not be null");
        }
        if (!url.matches("https?://.*")) {
            throw new IllegalArgumentException("url must start with http:// or https://");
        }
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
