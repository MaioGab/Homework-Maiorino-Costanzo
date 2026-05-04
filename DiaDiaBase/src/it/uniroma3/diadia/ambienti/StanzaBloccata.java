package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	public String direzioneBloccata;
	public String attrezzoNecessario;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoNecessario) {
		super(nome);
		this.direzioneBloccata= direzioneBloccata;
		this.attrezzoNecessario= attrezzoNecessario;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(direzioneBloccata.equals(dir) && !this.hasAttrezzo(attrezzoNecessario))
			return this;
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		String stanzaBloccata= "Stanza bloccata nella direzione " + this.direzioneBloccata + ", prendi " + this.attrezzoNecessario + " e posalo nella stanza ";
		if(!this.hasAttrezzo(attrezzoNecessario))
			return stanzaBloccata;
		return super.getDescrizione();
	}
}
