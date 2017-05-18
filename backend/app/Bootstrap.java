import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        //Checa se o db esta vazio
        if(Usuario.count() == 0 && Cargo.count() == 0 && PerfilUsuario.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}