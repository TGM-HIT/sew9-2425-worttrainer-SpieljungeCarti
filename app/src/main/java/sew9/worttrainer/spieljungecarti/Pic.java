package sew9.worttrainer.spieljungecarti;

public class Pic {

    private String url;
    private String name;

    public Pic(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean viable() {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return false;
        }

        if (!url.endsWith(".jpg") && !url.endsWith(".png")) {
            return false;
        }

        return true;
    }
}
