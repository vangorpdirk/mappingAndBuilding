package be.craftcode.mappingdemo.responses;

public class CovidResponse {
    private int id;
    private String type;
    private String lineage;
    private String firstDocumented;

    public CovidResponse(CovidResponseBuilder builder) {
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

    public static class CovidResponseBuilder {
        private int id;
        private String type;
        private String lineage;
        private String firstDocumented;

        public CovidResponseBuilder(int id) {
            this.id = id;
        }

        public CovidResponseBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CovidResponseBuilder lineage(String lineage) {
            this.lineage = lineage;
            return this;
        }

        public CovidResponseBuilder firstDocumented(String firstDocumented) {
            this.firstDocumented = firstDocumented;
            return this;
        }

        public CovidResponse build() {
            return new CovidResponse(this);
        }
    }
}
