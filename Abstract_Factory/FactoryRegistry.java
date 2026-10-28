package Abstract_Factory;

import java.util.Map;
import java.util.Locale;
import java.util.function.Supplier;

public class FactoryRegistry {

    private static final Map<String, Supplier<Factory>> factories =
            Map.of(
                    "ios", FactoryIOS::new,
                    "android", FactoryANDROID::new
            );

    public static Factory obterFactory(String tipo) {

        Supplier<Factory> criador =
                factories.get(tipo.toLowerCase(Locale.ROOT));

        if (criador == null) {
            throw new IllegalArgumentException(
                    "Plataforma não suportada: " + tipo
            );
        }

        return criador.get();
    }
}