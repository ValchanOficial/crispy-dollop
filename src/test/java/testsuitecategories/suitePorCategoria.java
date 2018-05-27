package testsuitecategories;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import categorias.Positivos;
import framework.report;
import testcase.loginTestCase;

@RunWith(Categories.class)
@IncludeCategory(Positivos.class)
@SuiteClasses({
		loginTestCase.class
})
public class suitePorCategoria {
	
	@BeforeClass
	public static void initTest() {
		report.create("Moodle QA Testing Site", "Suite de Regressao");
	}

	@AfterClass
	public static void endTest() {
		report.close();
	}
}