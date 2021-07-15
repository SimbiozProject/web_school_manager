package com.example.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import org.springframework.lang.Nullable;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.web.servlet.ModelAndView;

public class ExtendedModelResultMatchers extends ModelResultMatchers {
    public ResultMatcher attribute(String name, @Nullable Object value) {
        return result -> {
            ModelAndView mav = getModelAndView(result);
            assertThat(mav.getModel().get(name)).usingRecursiveComparison()
                    .ignoringAllOverriddenEquals()
                    .isEqualTo(value);
//            assertEquals("Model attribute '" + name + "'", value, mav.getModel().get(name));
        };
    }

    private ModelAndView getModelAndView(MvcResult mvcResult) {
        ModelAndView mav = mvcResult.getModelAndView();
        assertNotNull("No ModelAndView found", mav);
        return mav;
    }

}
