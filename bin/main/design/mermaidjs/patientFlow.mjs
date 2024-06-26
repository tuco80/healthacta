%%[![](https://mermaid.ink/img/pako:eNqNVGFv2jAQ_SuWq0pBgiqhEEY-TKpaKm3qWtRW_TDli5tcwFtiI8dpSwP_fWc7CbBSbSCh8_m95zvfMzVNZAo0ooPBIBaa6xwicp1Xv2RJUiCXUpRVrpmJK0HmLOEgNMTCwmOR5fI1WTKlyc19LAh-Sr3OgcwVJC0143kenaRJlmXjfqmV_A3RiZ-N0umwWQ5eeaqX0XD1tq_Rni1S2WhkGYTZ5N8a5ltWzwvFVst9GaeecixOcym6mmeiLdabCa0YYR2rRwaDr2QzZyVTXfsbvCG2WEBaXzPT4TeRya2TajYc64FvyE0OgimD8Fxo0Z1U7wjtVm7IEzjOd5Z_QtkJW9Zl10GxgnfkdB04eCNosZmp-geknNWzUlcpx2FLYhPkHtwpTT876F5LvGxy3t2zBgHKpZxC7zjRNNWW1DTQyTjErEzkArVsakNs5-6UR8XafKO-2zzk3qEX9gs8ir54VrxRtuGB8m7z4FpjASI98NWexR3z9LR5Phc5yXNY4AzWRMFKKs1UCQTRJGfkARIFnzsR7eeh9F8GnCteyNr8AtrzCd6b8dj8bjJXTMuybnxmFx9xZhCPfCXNAbUJuqMarOXtNG8reJFzlno2QBem6JDCeET2PhCMuPGyN5fGFiZ0TiAczbdndgtvpV26Xdkt8yRxaI3OTGCReTuitnp35FMF-Qs-yXs7Ds8tCd46KXhZMLz28jgRCZVS7j272NuljjJMhWzzH2W7HVfR0Tyecphv3IUA2qc45ILxFP-Va8OIqV5CATGNMEwhYzismMZii1BWafmwFgmNtKqgT5WsFksa4Z2XuKpWKdNwxRlatuiyKyZoVNM3Gg0nZ34wPg_Hvj_1g2Dih326xvRoejYJAj8MwtFoeh5-GW779F1KlPDPpuPxOBhjLpxOhtMwsHo_7aYpYfsHIEkX4w?type=png)](https://mermaid-js.github.io/mermaid-live-editor/edit#pako:eNqNVGFv2jAQ_SuWq0pBgiqhEEY-TKpaKm3qWtRW_TDli5tcwFtiI8dpSwP_fWc7CbBSbSCh8_m95zvfMzVNZAo0ooPBIBaa6xwicp1Xv2RJUiCXUpRVrpmJK0HmLOEgNMTCwmOR5fI1WTKlyc19LAh-Sr3OgcwVJC0143kenaRJlmXjfqmV_A3RiZ-N0umwWQ5eeaqX0XD1tq_Rni1S2WhkGYTZ5N8a5ltWzwvFVst9GaeecixOcym6mmeiLdabCa0YYR2rRwaDr2QzZyVTXfsbvCG2WEBaXzPT4TeRya2TajYc64FvyE0OgimD8Fxo0Z1U7wjtVm7IEzjOd5Z_QtkJW9Zl10GxgnfkdB04eCNosZmp-geknNWzUlcpx2FLYhPkHtwpTT876F5LvGxy3t2zBgHKpZxC7zjRNNWW1DTQyTjErEzkArVsakNs5-6UR8XafKO-2zzk3qEX9gs8ir54VrxRtuGB8m7z4FpjASI98NWexR3z9LR5Phc5yXNY4AzWRMFKKs1UCQTRJGfkARIFnzsR7eeh9F8GnCteyNr8AtrzCd6b8dj8bjJXTMuybnxmFx9xZhCPfCXNAbUJuqMarOXtNG8reJFzlno2QBem6JDCeET2PhCMuPGyN5fGFiZ0TiAczbdndgtvpV26Xdkt8yRxaI3OTGCReTuitnp35FMF-Qs-yXs7Ds8tCd46KXhZMLz28jgRCZVS7j272NuljjJMhWzzH2W7HVfR0Tyecphv3IUA2qc45ILxFP-Va8OIqV5CATGNMEwhYzismMZii1BWafmwFgmNtKqgT5WsFksa4Z2XuKpWKdNwxRlatuiyKyZoVNM3Gg0nZ34wPg_Hvj_1g2Dih326xvRoejYJAj8MwtFoeh5-GW779F1KlPDPpuPxOBhjLpxOhtMwsHo_7aYpYfsHIEkX4w)
---
title: Flujos de Consulta de un Paciente
---

flowchart LR
    style Preconsulta fill:#dcfff5,stroke:#0f4d92,stroke-width:2px
    style Consultando fill:#ffe6f7,stroke:#0f4d92,stroke-width:2px


subgraph Consultando
    direction LR
    Enconsulta(Entra a Consulta) --> |Pasar Paciente| Flagged{Falta Info}
    Flagged --> |Si| LlenarInfo(Llenar Info Paciente)
    Flagged --> |No| VerInfo(Jalar Info Paciente)
    LlenarInfo --> Consulta(Empezar Consulta)
    VerInfo --> faltaMedia{Estudios o Media Reciente}
    faltaMedia --> |Si| ListaMedia(Obtener Lista Media)
    faltaMedia --> |No| Consulta
    ListaMedia --> |Escoger Media| JalarMedia(Traer Media)
    JalarMedia --> |Escoger Otro| ListaMedia
    JalarMedia --> AbrirMedia(Abrir Media)
    AbrirMedia --> Consulta
end

subgraph Preconsulta
    %%title: Al llegar y reportarse con la Secre
    direction LR
    Entra(Pre Consulta) --> Primo{Primera Vez}
    Primo --> |Si| Datos{Llenar Datos}
    Primo --> |No| TipoCons{Tipo Consulta}
    Datos --> |Si| NuevoPad(Nuevo Padecimiento)
    Datos --> |No| Flag(Poner Flag falta info)
    Flag --> NuevoPad
    NuevoPad --> Encolar(Poner En Cola)
    TipoCons --> |Vuelve| Recons(Vuelve por misma cosa)
    TipoCons --> |Recurrente| Recurr(Recurrente)
    TipoCons --> |Nueva| NuevoPad
    NuevoPad --> Encolar
    Recons --> Encolar
    Recurr --> Encolar
end


 