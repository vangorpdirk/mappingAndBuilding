# Two easy to use building structures for your REST API

I've always been a fan of Lego, you start with those ready-to-build boxes and after some time your creativity takes over. Building Lego's is creative, but you'll also need to use certain techniques in defining structure for your creation. Very much like in software development where some structures will make your code easier and future proof. In this post I'm referring to mapping and building objects. 

## Customize mapping

Let me state the obvious. I used mappers ever since I started developing REST API's in Java. Orika, Mapstruct or JMapper are some examples of great tools that will speed up the development process. But recently I learned it can be more practical to write your own mappers. A simple interface and an implementation that maps the correct objects from layer to layer. Let say you map your dto to a response. The interface would only say dtoToReponse and the implementation could be for any object passing through the layers. In my example it's types of the Covidvirus which caused waves according to the [WHO](https://www.who.int/). My mapper returns the correct response and takes a certain DTO.

    @Override
    public CovidResponse covidDTOToResponse(CovidDTO covidDTO) {
        if (covidDTO == null) {
            return null;
        }

        return new CovidResponse.CovidResponseBuilder(covidDTO.getId())
                .type(covidDTO.getType())
                .lineage(covidDTO.getLineage())
                .firstDocumented(covidDTO.getFirstDocumented())
                .build();
    }

This is a basic mapper which is actually not that hard to implement and which takes out all code inside the actual controller, service and repo. In the controller you'll only have to call on your custom mapper which can be done with one line of code instead of writing a conversion for each object. 

    List<CovidResponse> covidResponses = waveService.getAllCovids().stream()
                    .map(mapCovids::covidDTOToResponse).collect(Collectors.toList());

    return new ResponseEntity<>(covidResponses, HttpStatus.OK);

A benefit to customizing mappers, for me, is that you keep control over the code. You don't rely on external dependencies and you don't have to learn anything new for customizing your code. Simple Java code which can be used anywhere. 

## Write your own builders

Another popular tool out there is the @Builder. Lombok has one, but there are other builder-tools to be found. And yes, I like them too. Simple, easy to use and keeping the code maintainable. But as with mappers, external libraries can be a pain in the *ss during maintenance and there never as customizable as you want. Since the builderpattern is around for ages (this is a guess, I'm not a software historian) I like to write objects that build themselves in plain old java. 

    public CovidResponse(CovidResponseBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.lineage = builder.lineage;
        this.firstDocumented = builder.firstDocumented;
    }

The constructor takes a builder which returns the values from an internal, static class.

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

This code makes it very easy to create new objects or to pass values along different layers with the mapping structure explained above. Creating a new object can now be done with a simple chain of setters. 

    new CovidResponse.CovidResponseBuilder(covidDTO.getId())
            .type(covidDTO.getType())
            .lineage(covidDTO.getLineage())
            .firstDocumented(covidDTO.getFirstDocumented())
            .build();

# Conclusion 

I know 

The full code can be found on our [Craftcode Github]()