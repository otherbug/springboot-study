package priv.ys.util.xml;

public class XStreamMediaIdConverter extends XStreamCDataConverter {
    public XStreamMediaIdConverter() {
    }

    public String toString(Object obj) {
        return "<MediaId>" + super.toString(obj) + "</MediaId>";
    }
}
