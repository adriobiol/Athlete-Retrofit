import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class Sync {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AtletaService atletaService = retrofit.create(AtletaService.class);
        Response<List<Atleta>> response = atletaService.getTodosAtletas().execute();
        if(response.isSuccessful()){
            List<Atleta> atletaList = response.body();
            System.out.println("Status Code: " +response.code() +System.lineSeparator() + "Obtener Todos atletas: "+
            atletaList);

        }else{
            System.out.println("Status Code: " + response.code() + "ERROR: " + response.errorBody());
        }

        Response<List<Atleta>> responseErrorUrl = atletaService.getError().execute();

        if(!responseErrorUrl.isSuccessful()){
            System.out.println("Status Code: " + responseErrorUrl.code() + "ERROR: " + responseErrorUrl.raw());
        }

        Atleta atleta = new Atleta();
        atleta.setNombre("Obi");
        atleta.setApellido("Nava");
        atleta.setNacionalidad("Barcelona");
        atleta.setNacimiento(LocalDate.of(1997, 03,12));
        Response<Atleta> Atletastot = atletaService.createAtletas(atleta).execute();

        if(Atletastot.isSuccessful()) {
            Atleta atletaR = Atletastot.body();
            System.out.println("Status Code: " + Atletastot.code() + System.lineSeparator() + "Post jugador: " +
                    atletaR);

            Response<Atleta> response1atleta = atletaService.getAtletas(atletaR.getId()).execute();
            if(response1atleta.isSuccessful()){
                System.out.println("GET 1- Codigo Status: " + response1atleta.code() + "Atleta: "
                + response1atleta.body());
            }else{
                System.out.println("Status Code: " + response1atleta.code() + "ERROR: "
                        + response1atleta.errorBody());
            }

            atletaR.setNacionalidad("Madriz");
            Response<Atleta> insertarAtleta = atletaService.updateAtleta(atletaR).execute();
            if(response1atleta.isSuccessful()){
                System.out.println("Status Code: " + insertarAtleta.code() + System.lineSeparator() +
                "Insert jugador: " + insertarAtleta.body());
            }else{
                System.out.println("Status Code: " + insertarAtleta.code() + "ERROR: " +
                insertarAtleta.errorBody());
            }

            Response<Void> borraratleta = atletaService.deleteAtleta(atletaR.getId()).execute();
            System.out.println("Delete Status Code: " + borraratleta.code());

            response = atletaService.getTodosAtletas().execute();

            System.out.println("Delete atleta: " + "Status Code: " + response.code()
            + System.lineSeparator() + "Lista de jugadores: " + response.body());

        }

    }

}
