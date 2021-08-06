
package interfacesGui;

public enum Token {
    IDENTIFICADOR("Identificador: "),
    ENTERO("Entero: "),
    DECIMAL("Decimal: "),
    SIMBOLO("Simbolo: "),
    ERROR("Error: ");
    
    private final String tipoDeToken;
    private Token(String tipoDeToken){
        this.tipoDeToken = tipoDeToken;
    }
    public String getTipoDeToken(){
        return tipoDeToken;
    }
}
