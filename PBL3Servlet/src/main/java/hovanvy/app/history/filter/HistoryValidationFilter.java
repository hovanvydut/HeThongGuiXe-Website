package hovanvy.app.history.filter;

import static hovanvy.common.validator.DateValidator.DateValidationResult.DATE_FORMAT_NOT_VALID;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.validator.DateValidator;
import hovanvy.common.validator.DateValidator.DateValidationResult;

/**
 * @author hovanvydut
 *
 */

@WebFilter(urlPatterns = {"/history/details"})
public class HistoryValidationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String fromDate = (String) request.getParameter("fromDate");
        String toDate = (String) request.getParameter("toDate");
		
        DateValidationResult result1 = DateValidator.isValid().apply(toDate);
        DateValidationResult result2 = DateValidator.isValid().apply(fromDate);
        
        if (result1.equals(DATE_FORMAT_NOT_VALID) || result2.equals(DATE_FORMAT_NOT_VALID)) {
        	response.sendError(500);
        	return;
        }
        
        chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		
	}

}
