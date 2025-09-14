package uk.gov.hmcts.reform.dev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import io.micrometer.core.ipc.http.HttpSender.Response;
import io.swagger.v3.oas.models.examples.Example;
import uk.gov.hmcts.reform.dev.controllers.CaseController;
import uk.gov.hmcts.reform.dev.models.ExampleCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class DemoUnitTest {

    @Test
    void exampleOfTest() {
        assertTrue(System.currentTimeMillis() > 0, "Example of Unit Test");
    }

    @Test
    void getExampleCaseTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<ExampleCase> res = caseController.getExampleCase();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(1, res.getBody().getId());
        assertEquals("ABC12345", res.getBody().getCaseNumber());
        assertEquals("Case Title", res.getBody().getTitle());
        assertEquals("Case Description", res.getBody().getDescription());
        assertEquals("Case Status", res.getBody().getStatus());
    }

    @Test
    void createTaskTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<ExampleCase> res = caseController.createTask();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(2, res.getBody().getId());
        assertEquals("DEF67890", res.getBody().getCaseNumber());
        assertEquals("Case Title 2", res.getBody().getTitle());
        assertEquals("Case Description 2", res.getBody().getDescription());
        assertEquals("Case Status 2", res.getBody().getStatus());
    }

    @Test
    void getTaskTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<ExampleCase> res = caseController.getTask();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(3, res.getBody().getId());
        assertEquals("AAA11122", res.getBody().getCaseNumber());
        assertEquals("Case Title 3", res.getBody().getTitle());
        assertEquals("Case Description 3", res.getBody().getDescription());
        assertEquals("Case Status 3", res.getBody().getStatus());
    }

    @Test
    void getAllTasksTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<List<ExampleCase>> res = caseController.getAllTasks();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(3, res.getBody().size());
        assertEquals(1, res.getBody().get(0).getId());
        assertEquals("ABC12345", res.getBody().get(0).getCaseNumber());
        assertEquals("Case Title", res.getBody().get(0).getTitle());
        assertEquals("Case Description", res.getBody().get(0).getDescription());
        assertEquals("Case Status", res.getBody().get(0).getStatus());
        assertEquals(2, res.getBody().get(1).getId());
        assertEquals("DEF67890", res.getBody().get(1).getCaseNumber());
        assertEquals("Case Title 2", res.getBody().get(1).getTitle());
        assertEquals("Case Description 2", res.getBody().get(1).getDescription());
        assertEquals("Case Status 2", res.getBody().get(1).getStatus());
        assertEquals(3, res.getBody().get(2).getId());
        assertEquals("AAA11122", res.getBody().get(2).getCaseNumber());
        assertEquals("Case Title 3", res.getBody().get(2).getTitle());
        assertEquals("Case Description 3", res.getBody().get(2).getDescription());
        assertEquals("Case Status 3", res.getBody().get(2).getStatus());
    }

    @Test
    void updateTaskStatusTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<ExampleCase> res = caseController.updateTaskStatus();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(4, res.getBody().getId());
        assertEquals("BBB11133", res.getBody().getCaseNumber());
        assertEquals("Case Title 4", res.getBody().getTitle());
        assertEquals("Case Description 4", res.getBody().getDescription());
        assertEquals("Case Status 4", res.getBody().getStatus());
    }

    @Test
    void deleteTaskTest(){
        CaseController caseController = new CaseController();
        ResponseEntity<ExampleCase> res = caseController.deleteTask();
        assertNotNull(res);
        assertEquals("200 OK", res.getStatusCode().toString());
        assertEquals(5, res.getBody().getId());
        assertEquals("CCC22233", res.getBody().getCaseNumber());
        assertEquals("Case Title 5", res.getBody().getTitle());
        assertEquals("Case Description 5", res.getBody().getDescription());
        assertEquals("Case Status 5", res.getBody().getStatus());
    }


}
