package recursos.sieteymedia;

public class Numero extends Carta {
    public Numero(int valor) {
        switch (valor) {
        case 0:
        case 1:
        case 2:
        case 3:
            this.valor = 1;
            break;
        case 4:
        case 5:
        case 6:
        case 7:
            this.valor = 2;
            break;
        case 8:
        case 9:
        case 10:
        case 11:
            this.valor = 3;
            break;
        case 12:
        case 13:
        case 14:
        case 15:
            this.valor = 4;
            break;
        case 16:
        case 17:
        case 18:
        case 19:
            this.valor = 5;
            break;
        case 20:
        case 21:
        case 22:
        case 23:
            this.valor = 6;
            break;
        default:
            this.valor = 7;
        }
    }

    @Override
    public float getValor() {
        return super.getValor();
    }
}
