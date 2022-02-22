package be.craftcode.mappingdemo.dto;

public class CovidDTO {
    private final int id;
    private String type;
    private String lineage;
    private String firstDocumented;

    public CovidDTO(CovidDTOBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.lineage = builder.lineage;
        this.firstDocumented = builder.firstDocumented;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLineage() {
        return lineage;
    }

    public String getFirstDocumented() {
        return firstDocumented;
    }

    public static class CovidDTOBuilder {
        private int id;
        private String type;
        private String lineage;
        private String firstDocumented;

        public CovidDTOBuilder(int id) {
            this.id = id;
        }

        public CovidDTOBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CovidDTOBuilder lineage(String lineage) {
            this.lineage = lineage;
            return this;
        }

        public CovidDTOBuilder firstDocumented(String firstDocumented) {
            this.firstDocumented = firstDocumented;
            return this;
        }

        public CovidDTO build() {
            return new CovidDTO(this);
        }
    }
}
