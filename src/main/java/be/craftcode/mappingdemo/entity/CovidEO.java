package be.craftcode.mappingdemo.entity;

public class CovidEO {
    private int id;
    private String type;
    private String lineage;
    private String firstDocumented;

    public CovidEO(CovidEOBuilder builder) {
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

    public static class CovidEOBuilder {
        private int id;
        private String type;
        private String lineage;
        private String firstDocumented;

        public CovidEOBuilder(int id) {
            this.id = id;
        }

        public CovidEOBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CovidEOBuilder lineage(String lineage) {
            this.lineage = lineage;
            return this;
        }

        public CovidEOBuilder firstDocumented(String firstDocumented) {
            this.firstDocumented = firstDocumented;
            return this;
        }

        public CovidEO build() {
            return new CovidEO(this);
        }
    }
}
