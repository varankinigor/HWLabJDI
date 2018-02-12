package enums;

import java.util.Objects;

public enum EpamPagesEnum {
    HOME,
    CONTACT_FORM,
    SERVICE,
    METALS_COLORS("Metals & Colors");

    public String text;

    EpamPagesEnum() {
    }

    EpamPagesEnum(String text) {
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
