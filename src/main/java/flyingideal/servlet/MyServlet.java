package flyingideal.servlet;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.HttpServletBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;

/**
 * Created by Administrator on 2017/5/18.
 */
public class MyServlet extends HttpServletBean {

    private String param;
    private Resource resource;

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return this.param;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return this.resource;
    }

    @PostConstruct
    public void postConstructTest() {
        System.out.println("@PostConstruct test");
    }

    @Override
    protected void initServletBean() throws ServletException {
        System.out.println("---in MyServlet initServletBean() Method ---");
        System.out.println("param = " + this.param);
        System.out.println("resource = " + this.resource.getFilename());
    }

    @PreDestroy
    public void preDestroyTest() {
        System.out.println("@PreDestroy test");
    }
}
