/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tide.nd.mazeweb;

import co.tide.nd.mazelibrary.LabEscape;
import co.tide.nd.mazelibrary.MazeUtils;
import co.tide.nd.mazelibrary.NoEscapeException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;

/**
 *
 * @author nicolas
 * 
 * http://localhost:8080/mazeweb/tide/mazeservice/drawPathForEscape?startX=3&startY=1&labyrinth=OOOOOOOOOO&labyrinth=OWWWWOWWWO&labyrinth=OWOOWOWOWO&labyrinth=OWWOWOWOWO&labyrinth=OWOOWWWOWW&labyrinth=OWOOOOOOOO&labyrinth=OWWWWWWWWO
 * 
 */
@Path("/mazeservice")
public class MazeService {

    @GET
    @Path("/drawPathForEscape")
    @Produces("application/json")
    public List<String> drawPathForEscape(
            @QueryParam(value = "startX") int startX,
            @QueryParam(value = "startY") int startY,
            @QueryParam(value = "labyrinth") String[] labyrinth) {

        try {
            for(int i = 0; i < labyrinth.length; i++) {
                labyrinth[i] = labyrinth[i].replaceAll("W", " ");
            }
            
            char[][] solution = LabEscape.drawPathForEscape(MazeUtils.toCharArray(labyrinth), startX, startY);
            String[] result = MazeUtils.toStringArray(solution);
            return Arrays.asList(result);
        }
        catch (NoEscapeException ex) {
            Logger.getLogger(MazeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
