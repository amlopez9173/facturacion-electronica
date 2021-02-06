package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoProduct;
import co.edu.cotecnova.facturacionelectronica.databuilder.ProductTestDataBuilder;
import co.edu.cotecnova.facturacionelectronica.dominio.dto.AutenticationRequest;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.FEUserDetailService;
import co.edu.cotecnova.facturacionelectronica.infraestructura.security.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProductoControllerIntegrationTest {

    private static final int PRODUCT_ID = 34;
    private static final int PRODUCT_ID_ELIMINAR = 42;
    private static final int PRODUCT_ID_NO_EXISTE = 1;
    private static final int CODE = 123456;
    private static final int CODE_UPDATE = 999010;
    private static final String NAME = "Cuaderno Argollado 500 páginas";

    private AutenticationRequest autenticationRequest;
    private UserDetails userDetails;
    private String token;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FEUserDetailService feUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @BeforeEach
    public void init(){
        autenticationRequest = new AutenticationRequest();
        autenticationRequest.setPassword("root");
        autenticationRequest.setUsername("root");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticationRequest.getUsername(), autenticationRequest.getPassword()));
        userDetails = feUserDetailService.loadUserByUsername(autenticationRequest.getUsername());
        token = jwtUtil.generatToken(userDetails);
    }

    @Test
    void getAllTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/products")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAllTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/products/paginador?page=1&size=3")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findByIdTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/products/{id}", PRODUCT_ID)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("productId").value(PRODUCT_ID));
    }

    @Test
    void findByIdExceptionTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/products/{id}", PRODUCT_ID_NO_EXISTE)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void saveTest() throws Exception {
        ComandoProduct comandoProduct = new ProductTestDataBuilder().conCode(CODE).buildComando();

        mvc.perform(MockMvcRequestBuilders.post("/products")
                .content(objectMapper.writeValueAsString(comandoProduct))
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void saveExceptionTest() throws Exception {
        ComandoProduct comandoProduct = new ProductTestDataBuilder().buildComando();

        mvc.perform(MockMvcRequestBuilders.post("/products")
                .content(objectMapper.writeValueAsString(comandoProduct))
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateTest() throws Exception {
        ComandoProduct comandoProduct = new ProductTestDataBuilder().conProductId(PRODUCT_ID).conName(NAME).conCode(CODE_UPDATE).buildComando();

        mvc.perform(MockMvcRequestBuilders.put("/products/{id}", PRODUCT_ID)
                .content(objectMapper.writeValueAsString(comandoProduct))
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateExceptionTest() throws Exception {
        ComandoProduct comandoProduct = new ProductTestDataBuilder().conProductId(PRODUCT_ID).conName(NAME).conCode(CODE_UPDATE).buildComando();

        mvc.perform(MockMvcRequestBuilders.put("/products/{id}", PRODUCT_ID_NO_EXISTE)
                .content(objectMapper.writeValueAsString(comandoProduct))
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/products/{id}", PRODUCT_ID_ELIMINAR)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteExceptionTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/products/{id}", PRODUCT_ID_NO_EXISTE)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}