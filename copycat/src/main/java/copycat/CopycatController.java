package copycat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CopycatController {
    @Autowired
    private CopyCatService service;

    @RequestMapping("/copy")
    public String copyGreeter(@RequestParam(value = "name") String name) {
        return service.copyGreeter(name);
    }
}
