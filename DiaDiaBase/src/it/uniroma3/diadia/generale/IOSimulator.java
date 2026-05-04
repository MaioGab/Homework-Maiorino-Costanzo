package it.uniroma3.diadia.generale;

public class IOSimulator implements IO{
	
	private String[] input;
	private String[] output;
	private int indiceInput;
	private int indiceOutput;
	
	public IOSimulator(String[] input) {
		this.input=input;
		this.output= new String[100];
		this.indiceInput=0;
		this.indiceOutput=0;
	}
	
	
	@Override
	public String leggiRiga() {
		if(indiceInput<input.length)
			return input[indiceInput++];
		return null;
	}
	
	
	@Override
	public void mostraMessaggio(String msg) {
		if(indiceOutput< output.length)
			output[indiceOutput]=msg;
	}
	
	public String[] getOutput() {
        return output;
    }
}
