package enums;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public enum EpamPagesEnum {
    HOME,
    CONTACT_FORM,
    SERVICE,
    METALS_COLORS("Metals & Colors");

    private String text;

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
