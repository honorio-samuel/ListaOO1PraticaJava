import org.example.Carro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarroTest {
    private Carro carro;

    @Test
    public void deveLigarCarroCorretamente() {
        Carro carro = new Carro("Toyota", "Corolla", 2022);
        carro.ligar();
        Assertions.assertEquals("Ligado", carro.getEstado());
    }

    @Test
    public void deveDesligarCarroEZerarVelocidade() {
        Carro carro = new Carro("Fiat", "Uno", 2010);
        carro.ligar();
        carro.acelerar(50);
        carro.desligar();

        Assertions.assertEquals("Desligado", carro.getEstado());
        Assertions.assertEquals(0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveAcelerarCorretamente() {
        Carro carro = new Carro("Honda", "Civic", 2020);
        carro.acelerar(20);
        Assertions.assertEquals(20, carro.getVelocidadeAtual());
    }

    @Test
    public void deveFrearSemFicarNegativo() {
        Carro carro = new Carro("VW", "Gol", 2015);
        carro.acelerar(10);
        carro.freiar(15);
        Assertions.assertEquals(0, carro.getVelocidadeAtual());
    }

    @Test
    public void deveLancarExcecaoParaAnoInvalido() {
        Carro carro = new Carro("Chevrolet", "Onix", 2021);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carro.setAno(1800);
        });
    }

    @Test
    public void deveLancarExcecaoParaAceleracaoNegativa() {
        Carro carro = new Carro("Ford", "Ka", 2018);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carro.acelerar(-10);
        });
    }
}