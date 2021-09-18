package xyz.jxch.tan.grafana;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/grafana/oracle")
public interface OracleCloudJson {

    @RequestMapping(value = "select", method = {RequestMethod.POST, RequestMethod.GET})
    String select(String sql);
}
