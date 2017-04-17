package co.edu.javeriana.ashyi.kiss.Actions;

import java.util.ArrayList;
import java.util.List;

import antlr.debug.Event;
import co.edu.javeriana.ashyi.kiss.Message;
import co.edu.javeriana.ashyi.kiss.Agents.Agent;
import co.edu.javeriana.ashyi.pumas.Actions.RepresentativeRequestProfile;

public class MainCheckRoute<T> extends MessagePassingAction<T>{
	
	public MainCheckRoute(Message mensaje) {
		super(mensaje);
	}

	//private Message datos;
	
	public T execute() {
		Message datos = (Message)this.getMensaje();
		// verificar cambios de actividades
		askProfile(datos, 1);
		return null;
	}
	
	/**
	 * Solicitar caracteristicas de perfil de usuario 
	 * @param datosLlegan datos del evento
	 * @param tipoRuta 0 --> inicial 1--> cambio
	 */
	private void askProfile(Message datosLlegan, int tipoRuta) {

		String aliasAgent = datosLlegan.getSenderAgent();

		List datosEnviar = new ArrayList<>();

		datosEnviar.add(aliasAgent);
		datosEnviar.add((int) datosLlegan.getMessage());// idActividad
		datosEnviar.add(tipoRuta);

		System.out.println("Solicitando perfil a PUMAS");
		String newAliasAgent = "";

		Agent agenteS = null;
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!: "+aliasAgent);

		if (aliasAgent.contains("Executor-")) {
			newAliasAgent = aliasAgent.replace("Executor-", "");
			agenteS = this.getAgent().getAdmLocal().getAgent("RepresentativeAgent-" + newAliasAgent);
		} else if (aliasAgent.contains("RepresentativeAgent-"))
			agenteS = this.getAgent().getAdmLocal().getAgent(aliasAgent);

		Message data = new Message(datosEnviar, aliasAgent, this.getAgent().getID());
		//Event evento = new Event(ExecutionRepresentativeGuard.class,data);
		RepresentativeRequestProfile evento = new RepresentativeRequestProfile(data);
		agenteS.executeAction(evento);
	}
}
