package greeter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greeter",
        produces = "application/vnd.spencr.v1+json",
        consumes = "application/vnd.spencr.v1+json")
class GreeterController {
    private String name;

    @GetMapping
    public ResponseEntity<String> greet() {
        if(name == null)
            return new ResponseEntity<String>( "Hello world", HttpStatus.OK);
        return new ResponseEntity<String>( "Hello, " + name + ".\n Hope you are doing well.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity learnName(@RequestParam(value = "name") String name) {
        this.name = name;
        return new ResponseEntity(HttpStatus.OK);
    }
}
