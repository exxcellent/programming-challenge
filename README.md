# Compile
Run `mvn package` to compile and generate the executable in the target folder.

# Run
Run the executable inside the target folder
`java -cp target/challenge-1.0-SNAPSHOT.jar de.exxcellent.challenge.App`

# Run tests
`mvn test`

# Code structure
The `de.exxcellent.challenge.reader` package contains classes related to file reading.
Currently only has CSV reading functionality. JSON reading functionality can be added on later.

The `de.exxcellent.challenge.finder` package contains classes related to finding the
row with the least difference based on specific criteria.