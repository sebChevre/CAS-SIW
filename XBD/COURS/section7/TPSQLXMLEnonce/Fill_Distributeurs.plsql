declare
c clob;
begin
c:= '
<distributeurs>
	<distributeur>
		<nom>Fnac</nom>
		<ville>Fribourg</ville>
		<catalogue>
			<bd ref="001" prix="19.30"/>
			<bd ref="003" prix="20.25"/>
			<bd ref="004" prix="15.40"/>
			<bd ref="005" prix="15.40"/>
			<bd ref="014" prix="13.55"/>
			<bd ref="015" prix="15.40"/>
			<bd ref="016" prix="18.30"/>
			<bd ref="020" prix="15.30"/>
			<bd ref="026" prix="17.20"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Fnac</nom>
		<ville>Geneve</ville>
		<catalogue>
			<bd ref="001" prix="19.30"/>
			<bd ref="003" prix="20.25"/>
			<bd ref="005" prix="15.40"/>
			<bd ref="006" prix="19.45"/>
			<bd ref="008" prix="15.60"/>
			<bd ref="010" prix="18.10"/>
			<bd ref="015" prix="12.35"/>
			<bd ref="016" prix="19.95"/>
			<bd ref="022" prix="15.00"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Fnac</nom>
		<ville>Lausanne</ville>
		<catalogue>
			<bd ref="005" prix="19.30"/>
			<bd ref="011" prix="20.25"/>
			<bd ref="023" prix="20.25"/>
			<bd ref="014" prix="15.40"/>
			<bd ref="009" prix="15.40"/>
			<bd ref="006" prix="15.40"/>
			<bd ref="007" prix="16.50"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Fnac</nom>
		<ville>Berne</ville>
		<catalogue>
			<bd ref="005" prix="19.30"/>
			<bd ref="012" prix="20.25"/>
			<bd ref="013" prix="21.25"/>
			<bd ref="014" prix="20.00"/>
			<bd ref="015" prix="18.75"/>
			<bd ref="016" prix="15.40"/>
			<bd ref="017" prix="16.70"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Sion</ville>
		<catalogue>
      <bd ref="005" prix="19.30"/>
			<bd ref="016" prix="19.30"/>
			<bd ref="017" prix="17.40"/>
			<bd ref="007" prix="13.00"/>
			<bd ref="018" prix="14.90"/>
			<bd ref="019" prix="13.50"/>
			<bd ref="020" prix="16.10"/>
			<bd ref="021" prix="17.70"/>
			<bd ref="022" prix="17.75"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Lausanne</ville>
		<catalogue>
			<bd ref="001" prix="19.30"/>
      <bd ref="005" prix="22.30"/>
			<bd ref="011" prix="20.25"/>
			<bd ref="030" prix="18.40"/>
			<bd ref="031" prix="13.70"/>
			<bd ref="032" prix="16.45"/>
			<bd ref="033" prix="14.30"/>
			<bd ref="034" prix="15.95"/>
			<bd ref="035" prix="16.70"/>
			<bd ref="036" prix="17.40"/>
			<bd ref="037" prix="20.40"/>
			<bd ref="038" prix="21.40"/>
			<bd ref="039" prix="12.50"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Geneve</ville>
		<catalogue>
      <bd ref="005" prix="21.30"/>
			<bd ref="019" prix="19.30"/>
			<bd ref="020" prix="20.25"/>
			<bd ref="021" prix="15.40"/>
			<bd ref="022" prix="19.95"/>
			<bd ref="023" prix="16.50"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Montreux</ville>
		<catalogue>
			<bd ref="005" prix="19.30"/>
			<bd ref="025" prix="20.25"/>
			<bd ref="026" prix="12.50"/>
			<bd ref="027" prix="15.40"/>
			<bd ref="028" prix="16.50"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Vevey</ville>
		<catalogue>
			<bd ref="029" prix="19.30"/>
			<bd ref="002" prix="20.25"/>
			<bd ref="004" prix="15.00"/>
			<bd ref="005" prix="15.90"/>
			<bd ref="007" prix="16.70"/>
			<bd ref="008" prix="13.50"/>
			<bd ref="009" prix="12.50"/>
			<bd ref="016" prix="11.50"/>
			<bd ref="017" prix="14.50"/>
			<bd ref="018" prix="12.50"/>
			<bd ref="019" prix="15.50"/>
			<bd ref="020" prix="16.50"/>
			<bd ref="021" prix="17.50"/>
			<bd ref="022" prix="12.50"/>
			<bd ref="023" prix="16.50"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Payot</nom>
		<ville>Fribourg</ville>
		<catalogue>
			<bd ref="001" prix="26.30"/>
			<bd ref="002" prix="37.10"/>
			<bd ref="003" prix="25.40"/>
			<bd ref="004" prix="26.30"/>
			<bd ref="005" prix="37.10"/>
			<bd ref="006" prix="25.40"/>
			<bd ref="007" prix="26.30"/>
			<bd ref="008" prix="37.10"/>
			<bd ref="009" prix="25.40"/>
			<bd ref="010" prix="26.30"/>
			<bd ref="011" prix="37.10"/>
			<bd ref="012" prix="25.40"/>
			<bd ref="013" prix="26.30"/>
			<bd ref="014" prix="37.10"/>
			<bd ref="015" prix="25.40"/>
			<bd ref="016" prix="26.30"/>
			<bd ref="017" prix="17.75"/>
			<bd ref="018" prix="25.40"/>
			<bd ref="019" prix="26.30"/>
			<bd ref="020" prix="37.10"/>
			<bd ref="021" prix="25.40"/>
			<bd ref="022" prix="26.30"/>
			<bd ref="023" prix="37.10"/>
			<bd ref="024" prix="25.40"/>
			<bd ref="025" prix="26.30"/>
			<bd ref="026" prix="37.10"/>
			<bd ref="027" prix="25.40"/>
			<bd ref="028" prix="26.30"/>
			<bd ref="029" prix="17.70"/>
			<bd ref="030" prix="17.50"/>
			<bd ref="031" prix="18.05"/>
			<bd ref="032" prix="31.10"/>
			<bd ref="033" prix="20.00"/>
			<bd ref="034" prix="19.00"/>
			<bd ref="035" prix="28.20"/>
			<bd ref="036" prix="19.95"/>
			<bd ref="037" prix="39.95"/>
			<bd ref="038" prix="23.10"/>
			<bd ref="039" prix="33.10"/>
		</catalogue>
	</distributeur>
	<distributeur>
		<nom>Librairies La Fontaine SA</nom>
		<ville>Lausanne</ville>
		<catalogue>
			<bd ref="027" prix="26.30"/>
			<bd ref="028" prix="26.30"/>
			<bd ref="005" prix="26.30"/>
			<bd ref="037" prix="26.30"/>
			<bd ref="028" prix="9.30"/>
			<bd ref="029" prix="9.30"/>
		</catalogue>
	</distributeur>
</distributeurs>';

INSERT INTO Distributeurs(DIS_PK,DIS_List) VALUES(1,SYS.XMLType.createXML(c));
end;