# MongoDB Examples

The project works with <a href="https://github.com/StepanMelnik/MongoDB_Examples/blob/master/src/main/java/com/sme/mongodb/repository/IArticleNameRepository.java">IArticleNameRepository</a> and covers almost all aspects to work with MongoDB.

## Description

The following unit test work with different MongoDb aspects:
* <a href="https://github.com/StepanMelnik/MongoDB_Examples/blob/master/src/test/java/com/sme/mongodb/repository/ArticleNameRepositoryIntegrationTest.java">ArticleNameRepositoryIntegrationTest</a> tests CRUD operations to work with a real Mongo DB;
* <a href="https://github.com/StepanMelnik/MongoDB_Examples/blob/master/src/test/java/com/sme/mongodb/repository/ArticleNameRepositorySearchByExampleIntegrationTest.java">ArticleNameRepositorySearchByExampleIntegrationTest</a> tests search functionality by Example instance with different matching;
* <a href="https://github.com/StepanMelnik/MongoDB_Examples/blob/master/src/test/java/com/sme/mongodb/repository/ArticleNameRepositoryTextSerachIntegrationTest.java">ArticleNameRepositoryTextSerachIntegrationTest</a> tests performs text searching. Important to index the needed fields with @TextIndexed annotations as described in ArticleName POJO. Also the index should be created as described in MongoDbConfiguration.java;

## Build

Clone and install <a href="https://github.com/StepanMelnik/Parent.git">Parent</a> project before building.

Create tester user as described in <a href="https://github.com/StepanMelnik/MongoDB_Examples/blob/master/shell/start.txt">shell/start.txt</a> file.


### Maven
	> mvn clean install
