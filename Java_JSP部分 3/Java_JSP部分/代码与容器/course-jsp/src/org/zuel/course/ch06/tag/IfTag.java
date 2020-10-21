package org.zuel.course.ch06.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {

    private boolean test;

    @Override
    public void doTag() throws IOException, JspException {
        if(test) {
            getJspBody().invoke(null);
        }
    }
    public void setTest(boolean test) {
        this.test = test;
    }
}
