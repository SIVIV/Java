package spring_intro.product_shop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_intro.product_shop.io.reader.Reader;
import spring_intro.product_shop.io.writer.Writer;
import spring_intro.product_shop.io.xmlparser.XmlParser;
import spring_intro.product_shop.models.dtos.binding.product.ProductBindingModel;
import spring_intro.product_shop.models.dtos.binding.user.UserBindingModel;
import spring_intro.product_shop.models.dtos.binding.user.UserXMLWrapper;
import spring_intro.product_shop.models.services.CategoryService;
import spring_intro.product_shop.models.services.ProductService;
import spring_intro.product_shop.models.services.UserService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

@Component
@Transactional
public class Runner implements CommandLineRunner {
    private static final String USER_JSON_LOCATION = "/inputJson/users.json";
    private static final String USER_XML_LOCATION = "/inputXml/users.xml";
    private static final String PRODUCT_JSON_LOCATION = "/inputJson/products.json";
    private static final String CATEGORY_JSON_LOCATION = "/inputJson/categories.json";
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;
    private final Reader reader;
    private final Writer writer;
    private final XmlParser xmlParser;

    @Autowired
    public Runner(Gson gson,
                  UserService userService,
                  CategoryService categoryService,
                  ProductService productService, Reader reader, Writer writer, XmlParser xmlParser) {
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.reader = reader;
        this.writer = writer;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedUserDataFromXml();
//        this.seedProductData();
//        this.seedCategoryData(); //TODO

//        List<ProductViewInRangeModel> viewModels = this.productService.getAllInRangeWithoutBuyer(200L, 1000L);
//        String jsonOutput = this.gson.toJson(viewModels);
//        this.writer.writeToFile("outputJson/products-in-range.json", jsonOutput);
//        String debug = "";


    }

    private void seedUserDataFromJson() throws IOException {
        String data = this.reader.readAll(USER_JSON_LOCATION);
        Type collectionType = new TypeToken<List<UserBindingModel>>() {
        }.getType();
        List<UserBindingModel> users = this.gson.fromJson(data, collectionType);
        //this.userService.save(users);
    }
    private void seedUserDataFromXml() throws IOException {
        String usersXml = this.reader.readAll(USER_XML_LOCATION);

        UserXMLWrapper usersAsDto = this.xmlParser.deserialize(usersXml, UserXMLWrapper.class);
        String usersAsString = this.xmlParser.serialize(usersAsDto);

        this.userService.save(usersAsDto.getUsers());
    }

    private void seedProductData() throws IOException {
        String data = this.reader.readAll(PRODUCT_JSON_LOCATION);
        Type collectionType = new TypeToken<List<ProductBindingModel>>() {
        }.getType();
        List<ProductBindingModel> products = this.gson.fromJson(data, collectionType);
        products.forEach(this::randomizeData);
        String debug = "";
        this.productService.save(products);
    }

    private void seedCategoryData() {
        //TODO
    }

    private void randomizeData(ProductBindingModel model) {
        Random random = new Random();
        int buyer = random.nextInt(58);
        if (buyer <= 56) {
            model.setBuyer((long) buyer);
        }
        int seller = random.nextInt(57);
        if (seller <= 56) {
            model.setSeller((long) seller);
        }
    }


}
