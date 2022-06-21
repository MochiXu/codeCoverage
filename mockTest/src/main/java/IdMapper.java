
public class IdMapper {

    private static final String BARCODE_TO_ID_MAP = "id:mapper";

    public String getIdMapper(String targetDatabase, String type) {
        return String.format("%s:%s:%s", targetDatabase, type, BARCODE_TO_ID_MAP);
    }



}

