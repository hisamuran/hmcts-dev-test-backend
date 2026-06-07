package uk.gov.hmcts.reform.dev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.models.examples.Example;
import uk.gov.hmcts.reform.dev.models.ExampleCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CaseController {

    private List<ExampleCase> cases;

    public CaseController(List<ExampleCase> cases) {
        this.cases = new ArrayList<ExampleCase>();
    }

    public List<ExampleCase> getCases() {
        return this.cases;
    }

    public void setCases(List<ExampleCase> cases) {
        this.cases = cases;
    }

    @GetMapping(value = "/get-example-case", produces = "application/json")
    public ResponseEntity<ExampleCase> getExampleCase() {
        return ok(new ExampleCase(1, "ABC12345", "Case Title",
                                  "Case Description", "Case Status", LocalDateTime.now()
        ));
    }

    @GetMapping(value = "/create-task", produces = "application/json")
    public ResponseEntity<ExampleCase> createTask(@RequestBody ExampleCase exampleCase) {
        // return ok(new ExampleCase(2, "DEF67890", "Case Title 2",
        //                           "Case Description 2", "Case Status 2", LocalDateTime.now()
        // ));
        this.cases.add(exampleCase);
        return ok(this.cases.getLast());
    }

    @GetMapping(value = "/retrieve-task", produces = "application/json")
    public ResponseEntity<ExampleCase> getTask() {
        return ok(new ExampleCase(3, "AAA11122", "Case Title 3",
                                  "Case Description 3", "Case Status 3", LocalDateTime.now()
        ));
    }

    @GetMapping(value = "/retrieve-all-tasks", produces = "application/json")
    public ResponseEntity<List<ExampleCase>> getAllTasks() {
        ExampleCase case1 = new ExampleCase(1, "ABC12345", "Case Title",
                                  "Case Description", "Case Status", LocalDateTime.now());
        ExampleCase case2 = new ExampleCase(2, "DEF67890", "Case Title 2",
                                  "Case Description 2", "Case Status 2", LocalDateTime.now());
        ExampleCase case3 = new ExampleCase(3, "AAA11122", "Case Title 3",
                                  "Case Description 3", "Case Status 3", LocalDateTime.now());
        List<ExampleCase> caseList = Arrays.asList(case1, case2, case3);

        this.setCases(caseList);

        return ok(this.cases);
    }

    @GetMapping(value = "/update-task-status", produces = "application/json")
    public ResponseEntity<ExampleCase> updateTaskStatus() {
        return ok(new ExampleCase(4, "BBB11133", "Case Title 4",
                                  "Case Description 4", "Case Status 4", LocalDateTime.now()
        ));
    }

    @GetMapping(value = "/delete-task", produces = "application/json")
    public ResponseEntity<ExampleCase> deleteTask() {
        return ok(new ExampleCase(5, "CCC22233", "Case Title 5",
                                  "Case Description 5", "Case Status 5", LocalDateTime.now()
        ));
    }

}
