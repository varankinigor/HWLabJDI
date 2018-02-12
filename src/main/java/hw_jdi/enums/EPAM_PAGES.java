package hw_jdi.enums;

import java.util.Objects;

public enum EPAM_PAGES {
    HOME,
    CONTACT_FORM,
    SERVICE,
    METALS_COLORS("Metals & Colors");

    public String text;

    EPAM_PAGES() {
    }

    EPAM_PAGES(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        if (Objects.isNull(text)) {
            return name().replaceAll("_", " ");
        } else {
            return text;
        }
    }
}
