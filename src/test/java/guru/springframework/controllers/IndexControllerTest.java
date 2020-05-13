package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;

public class IndexControllerTest extends TestCase {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    public void testGetIndexPage() {
        String viewName = controller.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}