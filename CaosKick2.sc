//written by @joseCao5
//rough two amp kick
//Part of CaosPercLib 1.1
CaosKick2 {
	*ar {|att= 0.01, rel= 0.5, modFreq= 1, modbw= 0.1, bw= 0.1, freq1= 60, freq2= 62, lowcutfreq= 50,  gate= 1, amp= 1|
		var kick,env;
   	     		kick=RHPF.ar(
						 Pulse.ar(
						     	Pulse.ar(modFreq,modbw,freq1,freq2),
						 bw,amp/4),
        		    lowcutfreq,0.5);
        		kick=CompanderD.ar(kick,0.6,0.59,0.8);
        		env=EnvGen.ar(Env.perc(att,rel),gate,doneAction:2);
    		^Pan2.ar(kick*env,[-1,0.98]);
		}
		*robot {|att= 0.01, rel= 0.5, modFreq= 1, modbw= 0.1, bw= 0.1, freq1= 60, freq2= 62, lowcutfreq= 50, amp= 1, t=1, tp=0 |
		var kick,env;
   	     		kick=RHPF.ar(
						 Pulse.ar(
						     	Pulse.ar(t,modbw,freq1,freq2),
						 bw,amp/4),
        		    lowcutfreq,0.5);
        		kick=CompanderD.ar(kick,0.6,0.59,0.8);
        		env=EnvGen.ar(Env.perc(att,rel),Impulse.kr(t,tp),doneAction:0);
    		^Pan2.ar(kick*env,[-1,0.98]);
		}
	}
