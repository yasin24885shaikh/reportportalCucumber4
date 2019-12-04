package skeleton;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


//@CucumberOptions(plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"})
@CucumberOptions(tags = "@ok", plugin = { "skeleton.RpListener" })
public class RunCukesTest {

        private TestNGCucumberRunner testNGCucumberRunner;

       /* @BeforeSuite
        public void loadCache() {
                try {
                        CacheManager.getInstance().loadCache();
                        CacheManager.getInstance().getFromCache(NonRevGenericConstants.TRIPTYPE_KEY);
                        CacheManager.getInstance().getFromCache(NonRevGenericConstants.PASSENGER_KEY);
                        CacheManager.getInstance().getFromCache(NonRevGenericConstants.PAYMENT_DETAILS_KEY);
                        // CacheManager.getInstance().getFromCache(NonRevGenericConstants.OTHER_BOOKING_DETAILS_KEY);
                        // CacheManager.getInstance().getFromCache(NonRevGenericConstants.AIRPORT_AUTO_COMPLETE_KEY);
                        CacheManager.getInstance().byPassLogInAsRequire();
                } catch (Exception e) {
                        System.err.println(" localCache error > " + e.getMessage());
                }


        }*/
/*

        @AfterSuite(alwaysRun = true)
        public void generateHTMLReports() throws Exception {
                CacheManager.getInstance().unLoadCache();
                ReportHelper helper = new ReportHelper();
                helper.setProjectName(NonRevUtil.getProperty(NonRevGenericConstants.PROJECT_NAME));
                helper.setBranchName(NonRevUtil.getProperty(NonRevGenericConstants.BRANCH_NAME));
                helper.setPlatForm(NonRevUtil.getProperty(NonRevGenericConstants.PLATFORM));
                helper.setBrowserName(NonRevUtil.getProperty(NonRevGenericConstants.BROWSER_TYPE));
                helper.generateCucumberReport();
                CucumberToJBehaveJSonConvertor.createXREFJson();
                AlmIntegrationHelper almHelper = new AlmIntegrationHelper();
                almHelper.invokeALMIntegration();
                // almHelper.invokeJenkinsIntegration();
        }
*/


        @Test(
                groups = {"cucumber"},
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios"
        )
        public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
                this.testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
                System.out.println("Im out runScenario");
        }

        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                System.out.println("Im in scenarios");
                return (this.testNGCucumberRunner == null)
                        ? new Object[0][0]
                        : this.testNGCucumberRunner.provideScenarios();
        }

        @BeforeClass(alwaysRun = true)
        public void setUpClass(ITestContext context) throws IOException {
                try {
                        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
                       /* String threadCount = Configuration.Configuration().getProperty("ThreadCount");
                        if (StringUtils.isEmpty(threadCount))
                                threadCount = "1";
                        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(threadCount));*/
                }catch (Exception e){
                        e.printStackTrace();
                }
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
                if (this.testNGCucumberRunner != null) {
                        this.testNGCucumberRunner.finish();
                }
        }
}

