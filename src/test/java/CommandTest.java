
import services.ProductService;

import org.junit.*;


public class CommandTest {

    private ProductService productService;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before test");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After test");
    }

    @Before
    public void initTest() {
        productService = new ProductService();
    }

    @After
    public void afterTest() {
        productService = null;
    }


    @Test
    public void testAddProduct() throws Exception {
        Assert.assertEquals(true, productService.newproduct("iphone"));
        Assert.assertEquals(false, productService.newproduct("iphone"));

    }

    @Test
    public void testAddPurchase() throws Exception {
        Assert.assertEquals(true, productService.newproduct("iphone"));
        Assert.assertEquals(true, productService.purchase("iphone", "1", "1000","10.05.2017"));
        Assert.assertEquals(true, productService.purchase("iphone", "2", "2000","10.06.2017"));
        Assert.assertEquals(false, productService.purchase("iphone", "2", "0","10.06.2017"));
        Assert.assertEquals(false, productService.purchase("iphone", "0", "2000","10.06.2017"));
    }

    @Test
    public void testAddDemand() throws Exception {
        Assert.assertEquals(true, productService.newproduct("iphone"));
        Assert.assertEquals(true, productService.purchase("iphone", "1", "1000","10.05.2017"));
        Assert.assertEquals(true, productService.purchase("iphone", "2", "2000","10.06.2017"));
        Assert.assertEquals(true, productService.demand("iphone", "2", "5000","10.07.2017"));
    }

    @Test
    public void testSalesReportTest1() throws Exception{
        Assert.assertEquals(true, productService.newproduct("iphone"));
        Assert.assertEquals(String.valueOf(7000.0), String.valueOf(productService.salesreport("iphone", "10.08.2017")));
    }
    @Test
    public void testSalesReportTest2() throws Exception{
        Assert.assertEquals(true, productService.newproduct("iphone"));
        Assert.assertEquals(null, productService.salesreport("iphone", "10.08.2015"));
    }

}
