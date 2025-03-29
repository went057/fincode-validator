# fincode-validator

This repo is an extension of [Jakarta Validation API](https://beanvalidation.org/). "fincode" stands for "financial code". 
The newly added validators are for validation of some kinds of financial identification code. The annotation @FIGI, @ISIN
@CUSIP and @SEDOL can be used in your Spring Boot applications.

## Usage

### FIGI
The validator of [FIGI](https://www.openfigi.com/about/overview).

### ISIN
The validator of [ISIN](https://en.wikipedia.org/wiki/International_Securities_Identification_Number). Implementation of
this validator is base on [apache commons validator](https://commons.apache.org/proper/commons-validator/).

### CUSIP
The validator of [CUSIP](https://en.wikipedia.org/wiki/CUSIP). Implementation of this validator is base on
[apache commons validator](https://commons.apache.org/proper/commons-validator/).

### SEDOL
The validator of [SEDOL](https://en.wikipedia.org/wiki/SEDOL). Implementation of this validator is base on
[apache commons validator](https://commons.apache.org/proper/commons-validator/).


## License
Fincode-validator is licensed under the Apache License Version 2.0. See the [LICENSE](https://github.com/apache/dubbo/blob/3.3/LICENSE) file for details.