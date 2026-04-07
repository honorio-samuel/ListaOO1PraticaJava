import org.example.Carro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarroTest {
    private Carro carro;

    @BeforeEach
    public void setUp() {
        this.carro = new Carro();
        this.carro.setMarca("Toyota");
        this.carro.setModelo("Corolla");
        this.carro.setAno(2023);
    }

    @Test
    public void deveLigarCarroCorretamente() {
        carro.ligar();
        Assertions.assertEquals("Ligado", carro.getEstado());
    }

    @Test
    public void deveDesligarCarroEZerarVelocidade() {
        carro.ligar();
        carro.acelerar(50);
        carro.desligar();

        Assertions.assertEquals("Desligado", carro.getEstado());
        Assertions.assertEquals(0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveAcelerarCorretamente() {
        carro.acelerar(20);
        Assertions.assertEquals(20, carro.getVelocidadeAtual());
    }

    @Test
    public void deveFrearSemFicarNegativo() {
        carro.acelerar(10);
        carro.freiar(15);
        Assertions.assertEquals(0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveLancarExcecaoParaAnoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carro.setAno(1800);
        });
    }

    @Test
    public void deveLancarExcecaoParaAceleracaoNegativa() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carro.acelerar(-10);
        });
    }
}