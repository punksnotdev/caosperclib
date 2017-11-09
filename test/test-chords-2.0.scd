s.boot;
s.scope;
Tuning.directory;

a = Tuning.et(24);

b = Scale.minor(a).degrees;

play{CaosKick.ar}

(
b = Scale.choose(7, 24);
[b.name, b.tuning.name].postln;
// b.degrees;
)


(
t=Tdef(\seq,{
	var int = Scale.locrian.degrees;
	var nota = Pxrand(b+48,inf).asStream;
	var time = Pwrand([0.125,0.25,0.5]/2,[0.85,0.1,0.05],inf).asStream;
	var ch = ['M', 'm', 'M7', 'm7', 'Mmaj7', 'mmaj7', '5dim7', '5aug7'];
	loop{
play{CaosChords.ar(ch.choose,att:0.01,rel:0.1,note:nota.resume, gate:1)};
		time.resume.wait;

	}
}).quant_(1).play;
)