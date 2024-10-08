package gosuclass.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "evaluation", url = "${api.url.evaluation}")
public interface EvaluationService {
    @RequestMapping(method = RequestMethod.POST, path = "/evaluations")
    public void preevaluate(@RequestBody Evaluation evaluation);
}
